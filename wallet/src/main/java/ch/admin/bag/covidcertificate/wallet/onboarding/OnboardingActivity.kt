package ch.admin.bag.covidcertificate.wallet.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.admin.bag.covidcertificate.wallet.R
import ch.admin.bag.covidcertificate.wallet.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

	private lateinit var binding: ActivityOnboardingBinding
	private lateinit var pagerAdapter: OnboardingSlidePageAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityOnboardingBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.viewPager.setUserInputEnabled(false)
		pagerAdapter = OnboardingSlidePageAdapter(this)
		binding.viewPager.setAdapter(pagerAdapter)
	}

	fun continueToNextPage() {
		val currentItem: Int = binding.viewPager.getCurrentItem()
		if (currentItem < pagerAdapter.getItemCount() - 1) {
			binding.viewPager.setCurrentItem(currentItem + 1, true)
		} else {
			setResult(RESULT_OK)
			finish()
			overridePendingTransition(R.anim.fragment_open_enter, R.anim.fragment_open_exit)
		}
	}

}