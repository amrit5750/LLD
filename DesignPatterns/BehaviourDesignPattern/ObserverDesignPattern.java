package DesignPatterns.BehaviourDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {

    public static void main(String[] args) {

        YouTubeChannnelImple channnel = new YouTubeChannnelImple();

        YouTubeSubScriber Alice = new YouTubeSubScriber("Alice");
        YouTubeSubScriber Bob = new YouTubeSubScriber("Bob");
        channnel.addSubScriber(Alice);
        channnel.addSubScriber(Bob);

        channnel.uplaodNewVideo("Java Design Patterns Tutorial");
        channnel.removeSubScriber(Bob);
        channnel.uplaodNewVideo("Observer Pattern in Action");

    }

}

/**
 * SubScriber
 */
interface SubScriber {
    void update(String Video);

}

class YouTubeSubScriber implements SubScriber {

    String subScriberName;

    YouTubeSubScriber(String subScriberName) {
        this.subScriberName = subScriberName;
    }

    @Override
    public void update(String video) {
        System.out.println(subScriberName + " is watching the video: " + video);
    }
}

class EmailNotification implements SubScriber {

    String email;

    EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void update(String Video) {
        System.out.println("Email has been sent to " + email + " to watching the video: " + Video);

    }
}

class PushNotification implements SubScriber {

    String device;

    PushNotification(String device) {
        this.device = device;
    }

    @Override
    public void update(String Video) {
        System.out.println("Norification has been sent to " + device + " to watching the video: " + Video);

    }
}

class YouTubeChannnelImple implements YouTubeChannnel {

    List<SubScriber> subScribers = new ArrayList<>();
    String video;

    @Override
    public void addSubScriber(SubScriber subScriber) {
        subScribers.add(subScriber);
    }

    @Override
    public void removeSubScriber(SubScriber subScriber) {
        subScribers.remove(subScriber);
    }

    @Override
    public void notifySusbscriber() {
        for (SubScriber subScriber : subScribers) {
            subScriber.update(video);
        }
    }

    public void uplaodNewVideo(String video) {
        this.video = video;
        notifySusbscriber();
    }

}

/**
 * YouTubeChannnel
 */
interface YouTubeChannnel {
    void addSubScriber(SubScriber subScriber);

    void removeSubScriber(SubScriber subScriber);

    void notifySusbscriber();
}
/////////////////////////////////// TRADATIONAL APPROACH /////////////

/*
 * 
 * class YouTubeChannel {
 * 
 * List<String> subscriberList;
 * String video;
 * 
 * YouTubeChannel() {
 * subscriberList = new ArrayList<>();
 * }
 * 
 * void addSubscriber(String name) {
 * subscriberList.add(name);
 * }
 * 
 * void uploadVideo(String video) {
 * this.video = video;
 * 
 * }
 * 
 * void notifySubscriber() {
 * for (String subScriber : subscriberList) {
 * System.out.println("Dear " + subScriber + " " + video + " is Uploaded");
 * 
 * }
 * 
 * }
 * }
 * 
 * class YouTubeSubscriber {
 * 
 * String name;
 * 
 * YouTubeSubscriber(String name) {
 * this.name = name;
 * }
 * 
 * void Subscribe(YouTubeChannel channel) {
 * channel.addSubscriber(name);
 * }
 * 
 * void watchingVideo(YouTubeChannel channel) {
 * System.out.println(name + " is watching the video " + channel.video);
 * }
 * 
 * }
 * 
 */
