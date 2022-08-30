package com.example.namo.Bottom.Home

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import com.example.namo.Login.LoginActivity
import com.example.namo.Bottom.MainActivity
import com.example.namo.R
import com.example.namo.databinding.FragmentMenuBinding
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.data.NidProfileResponse


class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=  FragmentMenuBinding.inflate(inflater,container,false)

        //메뉴창 닫기
        binding.menuClose.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
        }

        binding.testMenuLogout.setOnClickListener {
            logOut() //로그아웃
        }

//        if (AuthApiClient.instance.hasToken()) {  //발급받은 카카오 토큰이 있는 지 확인
//            setKakaoUserInfo()
//        }
//        else { //발급받은 토큰이 없으면 네이버
////            setNaverUserInfo()
//        }


//        //회원탈퇴
//        binding.testMenuWithdraw.setOnClickListener {
//            UserApiClient.instance.unlink { error ->
//                if (error != null) {
//                    Toast.makeText(context, "회원 탈퇴 실패 $error", Toast.LENGTH_SHORT).show()
//                }else {
//                    Toast.makeText(context, "회원 탈퇴 성공", Toast.LENGTH_SHORT).show()
//
//                    val intent = Intent(context, LoginActivity::class.java)
//                    startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
//                }
//            }
//        }


        return binding.root
}

    private fun logOut() {
        val spf = requireActivity().getSharedPreferences("token", Context.MODE_PRIVATE)
        val editor = spf.edit()

        spf.edit().clear().commit()

        editor.putInt("autoLogin", 0) // 자동 로그인 취소

        Log.e("logout-token", "access = ${spf.getString("access","")}, refresh = ${spf.getString("refresh","")}, auto-login = ${spf.getInt("autoLogin",0)}, site = ${spf.getString("site","")}")

        Toast.makeText(context, "로그아웃 성공", Toast.LENGTH_SHORT).show()
        startActivity(Intent(context, LoginActivity::class.java)) //LoginActivity로

    }

    /** 카카오 유저 정보 */
    private fun setKakaoUserInfo() {
        //카카오 유저 정보 얻어옴
        UserApiClient.instance.me { user, error ->
            binding.testListNameTv.text = "${user?.kakaoAccount?.profile?.nickname}"
            binding.testListEmailTv.text = "${user?.kakaoAccount?.email}"
            binding.testListBirthTv.text = "${user?.kakaoAccount?.birthday}"

            //로그아웃
            binding.testMenuLogout.setOnClickListener {
                UserApiClient.instance.logout { error ->
                    if (error != null) {
                        Toast.makeText(context, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                        Log.e("Kakao-Logout", "로그아웃")
                    }
                    val intent = Intent(context, LoginActivity::class.java)
                    startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))

                }
            }
        }
    }

    /** 네이버 유저 정보 */
    private fun setNaverUserInfo() {
        //네이버 정보를 위한 변수
        var email: String?
        var birthday: String?
        var name: String?

        val profileCallback = object : NidProfileCallback<NidProfileResponse> {
            override fun onSuccess(response: NidProfileResponse) {
                name = response.profile?.name.toString()
                email = response.profile?.email.toString()
                birthday = response.profile?.birthday.toString()
                if (name != null) {
                    binding.testListNameTv.text = "${name}"
                    binding.testListEmailTv.text = "${email}"
                    binding.testListBirthTv.text = "${birthday}"
                    Log.d("NAVER-Login", "네이버 로그인한 유저 정보 - 이름 : $name")
                    Log.d("NAVER-Login", "네이버 로그인한 유저 정보 - 이메일 : $email")
                    Log.d("NAVER-Login", "네이버 로그인한 유저 정보 - 생일 : $birthday")

                    //로그아웃
                    binding.testMenuLogout.setOnClickListener {
                        if (name != null) {
                            NaverIdLoginSDK.logout()
                            Toast.makeText(context, "네이버 로그아웃", Toast.LENGTH_SHORT).show()
                            Log.e("Naver-Logout", "로그아웃")
                            startActivity(Intent(context, LoginActivity::class.java)) //LoginActivity로
                        }
                    }
                }
            }
            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                Toast.makeText(context, "errorCode: $errorCode, errorDesc: $errorDescription", Toast.LENGTH_SHORT).show()
            }
            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }
        }
        NidOAuthLogin().callProfileApi(profileCallback)
    }

}