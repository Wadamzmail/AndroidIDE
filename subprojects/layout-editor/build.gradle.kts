plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "dev.mutwakil.androidide.layouteditor"

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(projects.subprojects.vectormaster)
    implementation(projects.core.common)
    implementation(projects.utilities.uidesigner)
    
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.activity.ktx182)
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.constraintlayout)
    implementation (libs.androidx.core.ktx)
    implementation (libs.androidx.preference.ktx)
    implementation (libs.androidx.recyclerview)
    implementation (libs.androidx.viewpager2)
    implementation (libs.androidx.palette.ktx)
    implementation (libs.google.material)
    implementation (libs.google.gson)
    implementation (libs.common.glide)

    implementation(libs.zoomage)
    implementation(libs.common.utilcode)
    implementation(libs.colorpickerview)
    implementation(libs.common.editor)
    implementation(libs.common.editor.textmate)
    implementation(libs.commons.text)
    implementation(libs.common.io)

}
