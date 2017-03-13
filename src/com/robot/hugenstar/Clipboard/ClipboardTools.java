package com.robot.hugenstar.Clipboard;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardTools {
    public static ClipboardManager clipboard = null;

   // �������������ı�
   public void copyTextToClipboard(final Context activity, final String str) throws Exception {
       clipboard = (ClipboardManager) activity.getSystemService(Activity.CLIPBOARD_SERVICE);
       ClipData textCd = ClipData.newPlainText("data", str);
       clipboard.setPrimaryClip(textCd);
   }    

   // �Ӽ������л�ȡ�ı�
   public String getTextFromClipboard() {
       if (clipboard != null && clipboard.hasPrimaryClip()
       && clipboard.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
           ClipData cdText = clipboard.getPrimaryClip();
           ClipData.Item item = cdText.getItemAt(0);
           return item.getText().toString();
       }
       return "null";
   }
}
