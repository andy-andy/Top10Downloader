package com.andreytarasenko.top10downloader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParseApplications {
    private String xmlData;
    private ArrayList<Application> applications;

    public ParseApplications(String xmlData) {
        this.xmlData = xmlData;
        applications = new ArrayList<>();
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public boolean process() {
        boolean status = true;
        Application currentRecord;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("entry")) {
                            inEntry = true;
                            currentRecord = new Application();
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        break;

                    default:
                        //Nothing else to do.
                }
                eventType = xpp.next();
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return true;
    }
}
