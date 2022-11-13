package com.exxpplore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.File
import java.io.FileOutputStream


class App : AppCompatActivity() {

    private fun writeToFile(fileName: String, content: String) {
        val path: File = applicationContext.filesDir
        try {
            val writer: FileOutputStream = FileOutputStream(File(path, fileName))
            writer.write(content.toByteArray())
            writer.close()
        } catch (e: Error) {
            e.printStackTrace()
        }
    }

    private fun createPlacesFile() {
        val fileName = "places.txt"
        val placesNames = arrayOf("No Filter","Cafeterias","Theatres","Museums","Steak Houses","Supermarkets")

        val path: File = applicationContext.filesDir
        val file = File(path, fileName)
        var text = ""
        file.createNewFile()

        placesNames.forEach {
            text += "$it,0\n"
        }
        writeToFile(fileName,text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        val firstStart = prefs.getBoolean("firstStart", true)

        if (firstStart) {
            val createFile = createPlacesFile()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView2)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)
    }

}