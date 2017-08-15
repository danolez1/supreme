package com.example.daniel.career;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by daniel on 5/30/17.
 */

public class IntroSlider extends AppIntro2 {

    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Browse","fonts/RalewayLight.ttf","Browse through varieties of careers","fonts/RalewayThin.ttf",R.drawable.browse,getResources().getColor(R.color.browse_background)));
        addSlide(AppIntroFragment.newInstance("Choose","fonts/RalewayLight.ttf","You can choose whichever you want or let our AI help you select based on certain criteria","fonts/RalewayThin.ttf",R.drawable.choose,getResources().getColor(R.color.choose_background)));
        addSlide(AppIntroFragment.newInstance("Develop","fonts/RalewayLight.ttf","Let us help you develop yourself in your career field","fonts/RalewayThin.ttf",R.drawable.develop, getResources().getColor(R.color.develop_background)));
        addSlide(AppIntroFragment.newInstance("Mentor","fonts/RalewayLight.ttf","Link up with successful people in your career field to mentors you","fonts/RalewayThin.ttf",R.drawable.link,getResources().getColor(R.color.link_background),getResources().getColor(R.color.link_title),getResources().getColor(R.color.link_title)));
        addSlide(AppIntroFragment.newInstance("Connect","fonts/RalewayLight.ttf","Connect with people of like minds and passion","fonts/RalewayThin.ttf",R.drawable.connect,getResources().getColor(R.color.connect_background)));
        addSlide(AppIntroFragment.newInstance("Opportunities","fonts/RalewayLight.ttf","Provides you with scholarships and fellowships updates","fonts/RalewayThin.ttf",R.drawable.oppourtunity,getResources().getColor(R.color.oppourtunity_background)));
        addSlide(AppIntroFragment.newInstance("Get Started","fonts/RalewayLight.ttf","Get Started now, what are you waiting for? ","fonts/RalewayThin.ttf",R.drawable.start,getResources().getColor(R.color.start_background)));

        showStatusBar(true);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setSeparatorColor(getResources().getColor(R.color.white));

        setFadeAnimation();
        //setZoomAnimation();
        //setFlowAnimation();
        setSlideOverAnimation();
       //setDepthAnimation();
        //setCustomTransformer(new ZoomOutPageTransformer());
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        loadLoginActivity();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onDonePressed() {
        super.onDonePressed();
        loadLoginActivity();
    }

    private void loadLoginActivity(){
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

}
