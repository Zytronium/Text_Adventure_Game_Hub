package com.zytronium.textadventuregamehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var storyTextView: TextView
    private lateinit var option1Btn: TextView
    private lateinit var option2Btn: TextView
    private lateinit var option3Btn: TextView
    private lateinit var option4Btn: TextView
    private lateinit var option5Btn: TextView
    private lateinit var option6Btn: TextView

    private var currentPath: String = "StoryA:0"

    private val story1: Array<StoryEvent> = arrayOf(
        StoryEvent("StoryA:0", StoryEventType.Normal, "Story A Intro Event Text Here. Something interesting happens... ", OptionsSet(arrayOf("Do absolutely nothing", "Do something.", "Do something else.", "Dodge the UltraMegaTech-5000 Deluxe HyperGizmo Extravaganza Pro Edition: The Marvelous Multifunctional Miracle Device of Unparalleled Awesomeness and Supreme Excellence with Galactic Gadgetry, Quantum Quirkiness, Turbocharged Techno-Titillation, and a splash of interdimensional wackiness – Your two-stop 6.1G WiFi disabled, Sci-Fi enabled, Bluetooth 2.0 compatibility, historically large, electromagnetic wave absorbing, solution for Astonishingly Spectacular, Jaw-Dropping, Mind-Boggling, and Outrageously Over-the-Top Technological Marvels Beyond Your Wildest Imagination Nicely Neat Reusable Extra Durable Checkered PVC Picnic Tablecloth with 6 Securing Clips - Pink (110 x 55-Inch, Set of 1) - Waterproof and Easy-to-Clean Table Cover for Indoors or Outdoors which is headed directly towards your cart at an incredibly fast rate of velocity.", null, null), arrayOf("StoryA:01", "StoryA:02", "StoryA:03", "StoryA:04", null, null))),
        StoryEvent("StoryA:01", StoryEventType.Normal, "Something interesting continues to happen and then stops briefly, only for it to continue again but at a slower rate of speed.", OptionsSet(arrayOf("Do nothing again.", "Do something", "Spontaneously evolve into a god.", "Do something else less interesting", null, null), arrayOf("StoryA:011", "StoryA:012", "StoryA:013", "StoryA:014", null, null))),
        StoryEvent("StoryA:02", StoryEventType.Normal, "Something else interesting happens.", OptionsSet(arrayOf("Do nothing.", "Do something again", "Do something else less interesting", null, null, null), arrayOf("StoryA:021", "StoryA:022", "StoryA:023", null, null, null))),
        StoryEvent("StoryA:03", StoryEventType.Normal, "Something interesting continues to happen.", OptionsSet(arrayOf("Do nothing.", "Do something", "Do something else again but less interesting", null, null, null), arrayOf("StoryA:031", "StoryA:032", "StoryA:033", null, null, null))),
        StoryEvent("StoryA:04", StoryEventType.BadEnding, "You were not supposed to dodge that! You died.", OptionsSet(arrayOf("Back To Main Menu", "Restart Story", "Go Back", "Quit", null, null), arrayOf("Menu", "StoryA:0", "StoryA:0", "just press home button lol", null, null))),

        StoryEvent("StoryA:013", StoryEventType.Good, "You spontaneously evolve into a god and skip to the end of the story and get the best ending possible.", OptionsSet(arrayOf("Create a time loop.", "Win.", "Destroy the universe.", "Die.", null, null), arrayOf("StoryA:013", "StoryA:0132", "StoryA:0133", "StoryA:0134", null, null))),

        StoryEvent("StoryA:0132", StoryEventType.GoodEnding, "You got the best ending.", OptionsSet(arrayOf("Back To Main Menu", "Restart Story", "Go Back", "Quit", null, null), arrayOf("Menu", "StoryA:0", "StoryA:013", "just press home button lol", null, null))),
        StoryEvent("StoryA:0133", StoryEventType.Bad, "You've destroyed the universe. Your ill intent is a force to be reckoned with, but there is nothing left to do. \nSo... What now?", OptionsSet(arrayOf("Do nothing.", null, null, null, null, null), arrayOf("StoryA:0133", null, null, null, null, null))),
        StoryEvent("StoryA:0134", StoryEventType.Bad, "You Died?", OptionsSet(arrayOf("Yes.", "Yes.", "No, gods can't die!", null, null, null), arrayOf("StoryA:01341", "StoryA:01341", "StoryA:01342", null, null, null))),

        StoryEvent("StoryA:01341", StoryEventType.BadEnding, "You died.", OptionsSet(arrayOf("Back To Main Menu", "Restart Story", "Go Back", "Quit", null, null), arrayOf("Menu", "StoryA:0", "StoryA:013", "just press home button lol", null, null))),
        StoryEvent("StoryA:01342", StoryEventType.BadEnding, "Infinite power includes the power to die, you indeed died. Well, life as a god didn't last long, you might be the first god to win a Darwin Award.", OptionsSet(arrayOf("Back To Main Menu", "Restart Story", "Go Back", "Quit", null, null), arrayOf("Menu", "StoryA:0", "StoryA:013", "just press home button lol", null, null))),

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        storyTextView = findViewById(R.id.story_text)
        option1Btn = findViewById(R.id.button1)
        option2Btn = findViewById(R.id.button2)
        option3Btn = findViewById(R.id.button3)
        option4Btn = findViewById(R.id.button4)
        option5Btn = findViewById(R.id.button5)
        option6Btn = findViewById(R.id.button6)

        updateStory()

    }

    private fun updateStory() {
        val event: StoryEvent = story1.find { it.path == currentPath } ?: StoryEvent("NotFound", StoryEventType.Bad, "Error 40.4: the part of the story you have reached either does not exist yet or there has been an error in finding it.", OptionsSet(arrayOf("Back To Main Menu(doesn't exist yet either)", "Restart Story", "Quit(doesn't work yet either)", null, null, null), arrayOf("Menu", "StoryA:0", "just press home button lol", null, null, null)))
        println("updating story..")
        storyTextView.text = getString(R.string.story_text, event.storyText)

        option1Btn.text = event.options.optionTexts[0].toString()
        option2Btn.text = event.options.optionTexts[1].toString()
        option3Btn.text = event.options.optionTexts[2].toString()
        option4Btn.text = event.options.optionTexts[3].toString()
        option5Btn.text = event.options.optionTexts[4].toString()
        option6Btn.text = event.options.optionTexts[5].toString()

        if (event.options.optionTexts[0] == null) option1Btn.visibility = View.GONE else option1Btn.visibility = View.VISIBLE
        if (event.options.optionTexts[1] == null) option2Btn.visibility = View.GONE else option2Btn.visibility = View.VISIBLE
        if (event.options.optionTexts[2] == null) option3Btn.visibility = View.GONE else option3Btn.visibility = View.VISIBLE
        if (event.options.optionTexts[3] == null) option4Btn.visibility = View.GONE else option4Btn.visibility = View.VISIBLE
        if (event.options.optionTexts[4] == null) option5Btn.visibility = View.GONE else option5Btn.visibility = View.VISIBLE
        if (event.options.optionTexts[5] == null) option6Btn.visibility = View.GONE else option6Btn.visibility = View.VISIBLE

        option1Btn.setOnClickListener {
            currentPath = event.options.optionPaths[0].toString()
        updateStory()
        }
        option2Btn.setOnClickListener {
            currentPath = event.options.optionPaths[1].toString()
        updateStory()
        }
        option3Btn.setOnClickListener {
            currentPath = event.options.optionPaths[2].toString()
        updateStory()
        }
        option4Btn.setOnClickListener {
            currentPath = event.options.optionPaths[3].toString()
        updateStory()
        }
        option5Btn.setOnClickListener {
            currentPath = event.options.optionPaths[4].toString()
        updateStory()
        }
        option6Btn.setOnClickListener {
            currentPath = event.options.optionPaths[5].toString()
        updateStory()
        }

    }

}

class OptionsSet(val optionTexts: Array<String?>, val optionPaths: Array<String?>) {

    //if something in the arrays is null, then the option will not appear.

}

class StoryEvent(val path: String, val type: StoryEventType, val storyText: String, val options: OptionsSet) {
}

enum class StoryEventType {
    Normal, Good, Bad, GoodEnding, BadEnding
}