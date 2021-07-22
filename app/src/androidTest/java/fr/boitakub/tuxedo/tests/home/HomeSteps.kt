package fr.boitakub.tuxedo.tests.home

import android.content.Intent
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import fr.boitakub.tuxedo.MainActivity
import fr.boitakub.tuxedo.R
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeSteps {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun cleanup() {
        Intents.release()
    }

    @Given("The app started")
    fun the_app_started() {
        activityRule.launchActivity(Intent())
    }

    @Then("I see home screen")
    fun i_see_home_screen() {
        intended(hasComponent(MainActivity::class.java.name))

        assertDisplayed(R.id.text_home, "This is home Fragment")
    }

}
