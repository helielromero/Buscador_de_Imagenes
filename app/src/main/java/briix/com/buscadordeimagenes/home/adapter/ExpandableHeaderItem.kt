package briix.com.buscadordeimagenes.home.adapter

import android.view.View
import com.xwray.groupie.ExpandableGroup
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.databinding.HeaderItemBinding
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.viewbinding.BindableItem

class ExpandableHeaderItem (): BindableItem<HeaderItemBinding>(),ExpandableItem
{
    private var expandableGroup: ExpandableGroup? = null

    override fun bind(viewBinding: HeaderItemBinding, position: Int) {
        // Initial icon state -- not animated.
        viewBinding.icon.visibility = View.VISIBLE
        viewBinding.icon.setImageResource(if (expandableGroup!!.isExpanded) R.drawable.ic_collapse else R.drawable.ic_expand)
        viewBinding.icon.setOnClickListener {
            expandableGroup!!.onToggleExpanded()
            bindIcon(viewBinding)
        }
    }

    private fun bindIcon(viewBinding: HeaderItemBinding) {
        viewBinding.icon.visibility = View.VISIBLE
        viewBinding.icon.setImageResource(if (expandableGroup!!.isExpanded) R.drawable.animator_collapse else R.drawable.animator_expand)
        //val drawable = viewBinding.icon.drawable as Animatable
        //drawable.start()
    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }

    override fun getLayout(): Int {
        return R.layout.header_item
    }

    override fun initializeViewBinding(view: View): HeaderItemBinding {
        return  HeaderItemBinding.bind(view)
    }

}