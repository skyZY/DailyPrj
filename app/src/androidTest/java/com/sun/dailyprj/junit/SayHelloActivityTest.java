package com.sun.dailyprj.junit;

import androidx.test.rule.ActivityTestRule;

import com.sun.dailyprj.R;
import com.sun.dailyprj.junit.operate.SayHelloActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/*
 * =====================================================================================
 * Summary:
 *
 * File: SayHelloActivityTest.java
 * Author: Yanpeng.Sun
 * Create: 2019/3/12 18:15
 * =====================================================================================
 */
public class SayHelloActivityTest{

    private static final String STRING_TO_BE_TYPED = "Peter";

    @Rule
    public ActivityTestRule<SayHelloActivity> mActivityRule = new ActivityTestRule<>(
            SayHelloActivity.class);

    @Test
    public void sayHello() {

        onView(withId(R.id.et_sayhello)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard()); //line 1

        onView(withText("Say hello!")).perform(click()); //line 2

        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";
        onView(withId(R.id.txt_sayhello)).check(matches(withText(expectedText))); //line 3
    }
}