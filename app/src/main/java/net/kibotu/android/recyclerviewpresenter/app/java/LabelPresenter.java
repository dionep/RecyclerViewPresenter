package net.kibotu.android.recyclerviewpresenter.app.java;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.kibotu.android.recyclerviewpresenter.Presenter;
import net.kibotu.android.recyclerviewpresenter.RecyclerViewModel;
import net.kibotu.android.recyclerviewpresenter.app.R;
import org.jetbrains.annotations.NotNull;

/**
 * Created by <a href="https://about.me/janrabe">Jan Rabe</a>.
 */

public class LabelPresenter extends Presenter<RecyclerViewModel<String>> {

    @Override
    public int getLayout() {
        return R.layout.label_presenter_item;
    }

    @Override
    public void bindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerViewModel<String> item, int position) {
        TextView label = viewHolder.itemView.findViewById(R.id.label);
        label.setText(item.getModel());
    }
}