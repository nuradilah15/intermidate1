package com.example.intermediatesub1.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.intermediatesub1.api.ListAllStoryItem

class DiffCallBackAccount (
    private val mOldFavList: List<ListAllStoryItem>,
    private val mNewFavList: List<ListAllStoryItem>
): DiffUtil.Callback() {
    override fun getOldListSize() = mOldFavList.size

    override fun getNewListSize() = mNewFavList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        mOldFavList[oldItemPosition].id == mNewFavList[newItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldFavList[oldItemPosition]
        val newEmployee = mNewFavList[newItemPosition]
        return oldEmployee.id == newEmployee.id
    }

}