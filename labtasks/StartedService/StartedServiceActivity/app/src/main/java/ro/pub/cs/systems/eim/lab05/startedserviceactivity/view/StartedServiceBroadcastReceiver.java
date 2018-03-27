package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;
import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 9 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 7 - get the action and the extra information from the intent
        // and set the text on the messageTextView
        String action = intent.getAction();
        String data = null;
        switch (action) {
            case Constants.ACTION_STRING:
                data = intent.getStringExtra(Constants.DATA);
            case Constants.ACTION_INTEGER:
                data = String.valueOf(intent.getIntExtra(Constants.DATA, -1));
            case Constants.ACTION_ARRAY_LIST:
                data = intent.getStringExtra(Constants.DATA).toString();
        }

        if (messageTextView != null)
            messageTextView.setText(messageTextView.getText().toString() + "\n" + data);

        // TODO: exercise 9 - restart the activity through an intent
        // if the messageTextView is not available
    }
}
