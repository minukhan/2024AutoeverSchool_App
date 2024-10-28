package com.example.datingapp.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.datingapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

class UploadActivity : AppCompatActivity() {
    private val REQUEST_CODE_CAMERA = 100
    private val REQUEST_CODE_GALLERY = 101
    private var imageUri: Uri? = null

    lateinit var imageView: ImageView
    private lateinit var loadingOverlay: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        imageView = findViewById(R.id.imageView)
        loadingOverlay = findViewById(R.id.loadingOverlay)

        findViewById<TextView>(R.id.btn_camera).setOnClickListener {
            openCamera()
        }

        findViewById<TextView>(R.id.btn_gallery).setOnClickListener {
            openGallery()
        }

        findViewById<TextView>(R.id.textViewUpload).setOnClickListener {
            upload(imageUri!!)
        }
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_CODE_CAMERA)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE_GALLERY)
    }

    private fun upload(uri: Uri) {
        if (imageUri == null) {
            return
        }

        // 로딩 서클 표시
        showLoading(true)

        // Firebase Storage 인스턴스 가져오기
        val storage = FirebaseStorage.getInstance()
        val storageRef: StorageReference = storage.reference

        // 이미지를 업로드할 위치 지정 (예: "images/userImage.jpg")
        val imageRef = storageRef.child("images/${System.currentTimeMillis()}.jpg")

        // 이미지 업로드
        val uploadTask: UploadTask = imageRef.putFile(uri)

        uploadTask.addOnSuccessListener { taskSnapshot ->
            // 업로드 성공 시 URL 가져오기
            imageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                // 업로드 후 imageUri 초기화
                imageUri = null
                showLoading(false) // 로딩 서클 숨기기

                // downloadUrl을 Firestore에 저장하거나 사용
                println("Uploaded image URL: $downloadUrl")
                val auth = FirebaseAuth.getInstance()
                val currentUser = auth.currentUser
                if (currentUser != null) {
                    updateUserImage(currentUser.email!!, downloadUrl.toString())
                }
            }
        }.addOnFailureListener { exception ->
            // 업로드 실패 시 처리
            println("Error uploading image: $exception")
            Toast.makeText(this, "업로드 실패했습니다. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
            showLoading(false) // 로딩 서클 숨기기
        }
    }

    fun updateUserImage(email: String, imageUri: String) {
        val db = Firebase.firestore

        // 이메일로 사용자 검색
        db.collection("users")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    // 사용자 문서가 있을 때
                    for (document in documents) {
                        // 문서 ID를 가져와서 참조
                        val userRef = db.collection("users").document(document.id)

                        // 이미지 URI 추가
                        userRef.update("image", imageUri)
                            .addOnSuccessListener {
                                println("User image updated successfully")

                                // 메인 화면으로 이동
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            .addOnFailureListener { exception ->
                                println("Error updating user image: $exception")
                            }
                    }
                } else {
                    // 사용자 문서가 없는 경우
                    println("No user found with the provided email")
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting user documents: $exception")
            }
    }


    private fun showLoading(isLoading: Boolean) {
        loadingOverlay.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    // Bitmap을 URI로 변환하는 메서드
    private fun getImageUriFromBitmap(bitmap: Bitmap): Uri {
        val path = MediaStore.Images.Media.insertImage(contentResolver, bitmap, "Title", null)
        return Uri.parse(path)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_CAMERA -> {
                    val imageBitmap = data?.extras?.get("data") as Bitmap
                    // 카메라로 찍은 이미지를 이미지 뷰에 세팅
                    imageView.setImageBitmap(imageBitmap)
                    imageUri = getImageUriFromBitmap(imageBitmap)
                }
                REQUEST_CODE_GALLERY -> {
                    imageUri = data?.data
                    // 갤러리에서 선택한 이미지를 이미지 뷰에 세팅
                    imageView.setImageURI(imageUri)
                }
            }
        }
    }
}
