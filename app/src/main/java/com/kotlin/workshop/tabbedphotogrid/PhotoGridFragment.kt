package com.kotlin.workshop.tabbedphotogrid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val SOURCE = "source"

class PhotoGridFragment : Fragment() {

    private lateinit var photoGrid: RecyclerView

    companion object {

        fun getInstance(photoSource: PhotoSource): PhotoGridFragment {
            val bundle = Bundle()
            bundle.putSerializable(SOURCE, photoSource)
            val photoGridFragment = PhotoGridFragment()
            photoGridFragment.arguments = bundle
            return photoGridFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.photo_grid_fragment, container, false)
        photoGrid = view.findViewById(R.id.photo_grid)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with (photoGrid) {
            adapter = PhotoGridAdapter(arguments?.getSerializable(SOURCE) as PhotoSource)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            itemAnimator = null
        }

    }

}