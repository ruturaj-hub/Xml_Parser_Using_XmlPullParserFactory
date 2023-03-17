package com.example.xmlparseri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var xml_data:InputStream = assets.open("file.xml")
        var factory= XmlPullParserFactory.newInstance()
        var parser = factory.newPullParser()

        parser.setInput(xml_data,null)
        var event = parser.eventType
        while (event != XmlPullParser.END_DOCUMENT){
            var tag_name = parser.name
            when (event){
                XmlPullParser.END_TAG -> {
                    if (tag_name == "student"){ //Just change the name of the tag to get the teacher's name and id
                        var name = "\n"+parser.getAttributeValue(0)+" "+parser.getAttributeValue(1)
                        editTextTextMultiLine.append(name)
                    }
                }
            }
            event = parser.next()
        }
    }
}