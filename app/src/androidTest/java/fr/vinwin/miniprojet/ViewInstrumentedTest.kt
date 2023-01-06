package fr.vinwin.miniprojet

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import fr.vinwin.miniprojet.view.MainActivity
import org.junit.Test

@MediumTest
class ViewInstrumentedTest {

    // Test infructeux à changer
    /*
        @Test
        fun result_text_shows_the_good_encrypted_text() {
            launchActivity<MainActivity>()
            Espresso.onView(ViewMatchers.withHint("Surface du bien"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click()).perform(
                ViewActions.replaceText("100.0")
            )

            Espresso.onView(ViewMatchers.withHint("Nombre de pièces"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click()).perform(
                    ViewActions.replaceText("4.0")
                )

            Espresso.onView(ViewMatchers.withHint("Surface terrain"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click()).perform(
                    ViewActions.replaceText("100.0")
                )

            Espresso.onView(ViewMatchers.withHint("Longitude"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click()).perform(
                    ViewActions.replaceText("1.070")
                )

            Espresso.onView(ViewMatchers.withHint("Latitude"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click()).perform(
                    ViewActions.replaceText("49.40")
                )

            Espresso.onView(ViewMatchers.withHint("Type de bien"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click()).perform(
                    ViewActions.replaceText("1")
                )

            Espresso.onView(ViewMatchers.withText("Estimer")).perform(ViewActions.click())

            Espresso.onView(ViewMatchers.withText("Le prix du bien est"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        }
*/

}