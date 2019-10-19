package abhilash.example.com.melonicious.customlistener;

import android.view.View;

public interface ClickListener {

    void onItemClick(View view, int position);

    void onLongItemClick(View view, int position);
}
