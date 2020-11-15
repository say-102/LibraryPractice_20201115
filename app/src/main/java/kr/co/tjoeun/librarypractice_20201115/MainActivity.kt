package kr.co.tjoeun.librarypractice_20201115

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.lifecycle_20201114.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {

//            ACTION_CALL 을 이용해서 바로 전화 연결 => 권한획득처리도 같이 진행

//            권한이있는지? 있을때 행동+없을때 행동 (가이드북) => 실제 권한 체크
//            TedPermission 라이브러리 활용

//            권한 상태에 따른 행동 요령 (가이드북-permissionListner) 작성

//            object : 가이드북을 담기 위한 임시(익명) 클래스 => 인터페이스 활용
//            : PermissionListener => object가 어떤 종류의 가이드북을 담는지?
//            Granted : 승인됐을때 코드, Denied : 거부되었을때 코드

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
//                    승인이되었다면? 실제 전화 연결
                    val myUri = Uri.parse("tel:010-8888-7777")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    거부되었다면? 통화 연결 불가 토스트
                    Toast.makeText(mContext, "권한이 거부되어 통화연결이 불가능합니다.", Toast.LENGTH_SHORT).show()

                }

            }


//            가이드북을 들고 => 실제로 권한 체크 실행

            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("전화 권한을 거부하면 연결이 불가합니다. [설정] 에서 권한을 켜주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()


        }

        viewPhotoBtn.setOnClickListener {
            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

        Glide.with(mContext).load("http://newsimg.sedaily.com/2019/12/31/1VSAE95B8P_1.jpg").into(firstImg)
        Glide.with(mContext).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRF-DT8Ca3OFbxcvkLNxqgqVnL_NrHuVv1bjQ&usqp=CAU").into(secondImg)

    }
}