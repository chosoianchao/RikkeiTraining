package com.rikkei.tranning.rikkeitraining2

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rikkei.tranning.rikkeitraining2.databinding.FragmentM002Binding


class M002Fragment : Fragment() {
    private var mContext: Context? = null
    private var mBinding: FragmentM002Binding? = null
    private var mediaPlayer: MediaPlayer? = null
    private var rootView: View? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        Log.i(TAG, "onAttach: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView: ")
        rootView = inflater.inflate(R.layout.fragment_m002, container, false)
        mBinding = FragmentM002Binding.bind(rootView!!)
        if (savedInstanceState == null) {
            mediaPlayer = MediaPlayer.create(mContext, R.raw.song_2)
            mediaPlayer?.start()
        }
        if (savedInstanceState != null) {
            val position = savedInstanceState.getInt("position")
            mediaPlayer?.seekTo(position)
        }
        initViews()
        return rootView
    }

    private fun initViews() {

        mBinding?.tvBack?.setOnClickListener {
            mediaPlayer?.pause()
            val act: MainActivity = mContext as MainActivity
            act.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        mediaPlayer?.currentPosition?.let { outState.putInt("position", it) }
        Log.i(TAG, "onSaveInstanceState: $outState")
        super.onSaveInstanceState(outState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            val position = savedInstanceState.getInt("position")
            mediaPlayer?.seekTo(position)
        }
        Log.i(TAG, "onActivityCreated: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i(TAG, "onDestroy: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView: ")
    }

    companion object {
        val TAG: String? by lazy { M002Fragment.javaClass.name }
    }
}