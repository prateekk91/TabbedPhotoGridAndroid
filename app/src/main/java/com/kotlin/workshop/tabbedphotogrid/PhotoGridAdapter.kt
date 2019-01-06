package com.kotlin.workshop.tabbedphotogrid

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager


class PhotoGridAdapter(private val photoSource: PhotoSource)
    : RecyclerView.Adapter<PhotoGridAdapter.PhotoViewHolder>() {

    private lateinit var imageLoader: RequestManager
    private var photoList = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        imageLoader = Glide.with(parent.context)
        return PhotoViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.photo_item, parent, false))
    }

    override fun getItemCount() = Int.MAX_VALUE

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        while (position >= photoList.size) {
            photoList.add(photoSource.getNext())
        }
        holder.bind(photoList[position], imageLoader)
    }

    class PhotoViewHolder(PhotoItemView: View) : RecyclerView.ViewHolder(PhotoItemView) {

        private val photoThumbnail =
                PhotoItemView.findViewById<ImageView>(R.id.photo_item)
        private val constraintLayout =
                PhotoItemView.findViewById<ConstraintLayout>(R.id.constraintLayout)
        private val constraintSet = ConstraintSet()

        fun bind(
                photo: Photo,
                imageLoader: RequestManager
        ) {
            val ratio = "${photo.width}:${photo.height}"
            with(constraintSet) {
                clone(constraintLayout)
                setDimensionRatio(photoThumbnail.id, ratio)
                applyTo(constraintLayout)
            }

            imageLoader
                    .load(photo.url)
                    .into(photoThumbnail)
        }
    }
}