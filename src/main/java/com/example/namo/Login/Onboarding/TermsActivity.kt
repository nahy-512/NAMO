package com.example.namo.Login.Onboarding

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.Login.LoginActivity
import com.example.namo.R
import com.example.namo.databinding.ActivityTermsBinding


//이용약관
class TermsActivity: AppCompatActivity() {
    lateinit var binding: ActivityTermsBinding

    var checkAllFlag = 0
    var checkEssential1 = 0
    var checkEssential2 = 0
    var checkOption1 = 0
    var checkOption2 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NaMo)

        binding = ActivityTermsBinding.inflate(layoutInflater)

        agreeAll() //전체 동의

        agreeService()  //이용약관
        agreePersonal() //개인정보
        agreeGps()      //위치
        agreeAlert()    //푸시 알림


        binding.termsNextBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java) //약관 체크 끝났으면 로그인
            startActivity(intent)
        }

        setContentView(binding.root)
    }



    private fun agreeAll() { //전체 동의
        binding.termsAgreeAllBtn.setOnClickListener {
            if (checkAllFlag == 0) {
                binding.termsAgreeAllBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                binding.termsAgreeServiceBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                binding.termsAgreePersonalBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                binding.termsAgreeGpsBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                binding.termsAgreeAlertBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                checkAllFlag = 1
                checkEssential1 = 1
                checkEssential2 = 1
                checkOption1 = 1
                checkOption2 = 1
                binding.termsNextBtn.isClickable = true;
                binding.termsNextBtn.backgroundTintList = ColorStateList.valueOf(getColor(R.color.MainOrange))

            } else if (checkAllFlag == 1) {
                binding.termsAgreeAllBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                binding.termsAgreeServiceBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                binding.termsAgreePersonalBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                binding.termsAgreeGpsBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                binding.termsAgreeAlertBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                checkAllFlag = 0
                checkEssential1 = 0
                checkEssential2 = 0
                checkOption1 = 0
                checkOption2 = 0
                binding.termsNextBtn.isClickable = false;
                binding.termsNextBtn.backgroundTintList = ColorStateList.valueOf(getColor(R.color.beforeOrange))
            }
        }
    }

    private fun agreeService() { //이용약관
        binding.termsAgreeServiceBtn.setOnClickListener {
            if (checkEssential1 == 0) {
                binding.termsAgreeServiceBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                checkEssential1 = 1
                moveNext()
            }
            else if (checkEssential1 == 1) {
                binding.termsAgreeServiceBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                checkEssential1 = 0
                allCheckReset()
                moveNext()
            }
        }
    }

    private fun agreePersonal() { //개인정보
        binding.termsAgreePersonalBtn.setOnClickListener {
            if (checkEssential2 == 0) {
                binding.termsAgreePersonalBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                checkEssential2 = 1
                moveNext()
            }
            else if (checkEssential2 == 1) {
                binding.termsAgreePersonalBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                checkEssential2 = 0
                allCheckReset()
                moveNext()
            }
        }
    }

    private fun agreeGps() { //위치
        binding.termsAgreeGpsBtn.setOnClickListener {
            if (checkOption1 == 0) {
                binding.termsAgreeGpsBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                checkOption1 = 1
                moveNext()
            }
            else if (checkOption1 == 1) {
                binding.termsAgreeGpsBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                checkOption1 = 0
                allCheckReset()
                moveNext()
            }
        }
    }

    private fun agreeAlert() { //푸시알림
        binding.termsAgreeAlertBtn.setOnClickListener {
            if (checkOption2 == 0) {
                binding.termsAgreeAlertBtn.setBackgroundResource(R.drawable.ic_terms_check_selected)
                checkOption2 = 1
                moveNext()
            }
            else if (checkOption2 == 1) {
                binding.termsAgreeAlertBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
                checkOption2 = 0
                allCheckReset()
                moveNext()
            }
        }
    }

    //필수 사항 모두 선택해야 버튼 활성화하고 다음 화면으로 넘어갈 수 있음
    private fun moveNext() {
        if (checkEssential1 == 1 && checkEssential2 == 1) {
            checkAllFlag = 1
            binding.termsNextBtn.isClickable = true
            binding.termsNextBtn.backgroundTintList = ColorStateList.valueOf(getColor(R.color.MainOrange))
        } else {
            checkAllFlag = 0
            binding.termsAgreeAllBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
            binding.termsNextBtn.isClickable = false
            binding.termsNextBtn.backgroundTintList = ColorStateList.valueOf(getColor(R.color.beforeOrange)) //groupCodeGray
        }
    }

    private fun allCheckReset() { //전체 동의 초기화
        binding.termsAgreeAllBtn.setBackgroundResource(R.drawable.ic_terms_check_not_selected)
        checkAllFlag = 0
    }
}