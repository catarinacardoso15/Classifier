package com.classifier.Controller;


import com.classifier.Domain.AttentionKeyboard;
import com.classifier.Domain.Keyboard;

import java.util.ArrayList;

/**
 *
 * @author Catarina
 */
public class AttentionKeyboardController {

    AttentionKeyboard keyboard;

    public AttentionKeyboardController() {
    }

    public AttentionKeyboardController(AttentionKeyboard keyboar) {
        this.keyboard = keyboar;
    }

    public AttentionKeyboard createResultKeyboard(ArrayList<Keyboard> key, double[] major) {
        keyboard = new AttentionKeyboard();
        double[] m = media(key);
        keyboard.setListKeyboard(key);
 
        keyboard.setMediaKDT(m[0]);
        if (m[0] > major[0]) {
            keyboard.setpKDT(100);
        } else {
            keyboard.setpKDT((m[0] * 100) / major[0]);
        }
        keyboard.setMediaTBK(m[1]);
        if (m[1] > major[1]) {
            keyboard.setpTBK(100);
        } else {
            keyboard.setpTBK((m[1] * 100) / major[1]);
        }

        return keyboard;
    }

    public double[] media(ArrayList<Keyboard> key) {
        double[] media = new double[2];
        media[0]=0.0;
        media[1]=0.0;
        for (int i = 0; i < key.size(); i++) {
            media[0] = media[0] + key.get(i).getKdt();
            media[1] = media[1] + key.get(i).getTbk();
        }
        media[0] = media[0] / key.size();
        media[1] = media[1] / key.size();
        return media;
    }

}
