package com.rikkei.tranning.rikkeitraining2

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rikkei.tranning.rikkeitraining2.databinding.M001fragmentBinding

class M001Fragment : Fragment() {
    private var mediaPlayer: MediaPlayer? = null
    private var mContext: Context? = null
    private var rootView: View? = null
    private var mBinding: M001fragmentBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.m001fragment, container, false)
        mBinding = M001fragmentBinding.bind(rootView!!)
        initViews()
        return rootView
    }

    private fun initViews() {
        mediaPlayer = MediaPlayer.create(context, R.raw.song_1)
        if (!(mediaPlayer == null || mediaPlayer?.isPlaying != true)) {
            mediaPlayer?.reset()
        }
        mediaPlayer?.start()
        mBinding!!.tvNext.setOnClickListener {
            Toast.makeText(context, "click", Toast.LENGTH_LONG).show()
            if (!(mediaPlayer == null || mediaPlayer?.isPlaying != true)) {
                mediaPlayer?.pause()
            }
            val mainActivity = (activity as MainActivity)
            mainActivity.showFrg()
        }
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

    companion object {
        val TAG: String? = M001Fragment.javaClass.name
    }
}