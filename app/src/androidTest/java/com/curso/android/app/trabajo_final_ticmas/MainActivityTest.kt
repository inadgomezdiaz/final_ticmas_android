package com.curso.android.app.trabajo_final_ticmas

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.trabajo_final_ticmas.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)

class MainActivityTest {
    @get: Rule
    var rule:ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun mainActivity_comparatorStrings(){
        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text_view_1)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("las cadenas son iguales!")
            )
        )
    }
    @Test
    fun mainActivity_comparatorStringsWhenArentEquals(){
        Espresso.onView(
            ViewMatchers.withId(R.id.edit_text_1)
        ).perform(
            ViewActions.typeText("a text")
        )
        Espresso.closeSoftKeyboard()
        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text_view_1)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("las cadenas son diferentes")
            )
        )
    }
    @Test
    fun mainActivity_comparatorStringsWhenAreEquals(){
        Espresso.onView(
            ViewMatchers.withId(R.id.edit_text_1)
        ).perform(
            ViewActions.typeText("a text")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.edit_text_2)
        ).perform(
            ViewActions.typeText("a text")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text_view_1)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("las cadenas son iguales!")
            )
        )
    }

}