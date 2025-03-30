// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
val Exchange by extra("com.norths.project.exchange")
val defaultApplicationId by extra(Exchange)
val defaultApplicationId1 by extra(Exchange)
