package com.cassio.replicawhatsapp_app12

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager): FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            ChatFragment()
        else if (position == 1)
            StatusFragment()
        else
            CallFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0)
            "Chat"
        else if (position == 1)
            "Status"
        else
            "Call"
    }
}