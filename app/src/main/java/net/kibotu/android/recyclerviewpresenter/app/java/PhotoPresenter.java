package net.kibotu.android.recyclerviewpresenter.app.java;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import net.kibotu.android.recyclerviewpresenter.Presenter;
import net.kibotu.android.recyclerviewpresenter.RecyclerViewModel;
import net.kibotu.android.recyclerviewpresenter.app.GlideApp;
import net.kibotu.android.recyclerviewpresenter.app.R;
import org.jetbrains.annotations.NotNull;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by <a href="https://about.me/janrabe">Jan Rabe</a>.
 */

public class PhotoPresenter extends Presenter<RecyclerViewModel<String>> {

    @Override
    public int getLayout() {
        return R.layout.photo_presenter_item;
    }

    @Override
    public void bindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerViewModel<String> item, int position) {
        ImageView photo = viewHolder.itemView.findViewById(R.id.photo);

        GlideApp.with(viewHolder.itemView.getContext().getApplicationContext())
                .load(item.getModel())
                .transition(withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(photo);
    }
}