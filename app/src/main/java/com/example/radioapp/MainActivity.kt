package com.example.radioapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.view.View
import android.widget.*
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()

        // Get radio group selected item using on checked change listener
        val radio_group = findViewById<RadioGroup>(R.id.radioGroup)
        radio_group.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(applicationContext," On checked change :"+
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()
            })
        // Get radio group selected status and text using button click event
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            // Get the checked radio button id from radio group
            var id: Int = radio_group.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                    var offId = findViewById<RadioButton>(R.id.off)
                var textV2 = findViewById<TextView>(R.id.textView3)
                val radio2: RadioButton = findViewById(id)
                textV2.setText( "${radio2.text} "+" MHz" )
            }else{
                // If no radio button checked in this radio group
                Toast.makeText(applicationContext,"On button click :" +
                        " nothing selected",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Get the selected radio button text using radio button on click listener
    fun radio_button_click(view: View){
        // Get the clicked radio button instance
        val radio_group = findViewById<RadioGroup>(R.id.radioGroup)
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }



    private fun initializeView() {
        // create objects of TextView and Seekbar
        val sliderValue: TextView = findViewById(R.id.textView1)
        val slider: SeekBar = findViewById(R.id.seekBar)

        // set the max value of the slider using setMax function
        slider.min = 20
        slider.max = 110

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // override the onProgressChanged method to perform operations
            // whenever the there a change in SeekBar
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sliderValue.text  = progress.toString() + " MHz"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}
