package com.rikkei.tranning.rikkeitraining2

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
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
        Log.i(TAG, "onAttach: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView: ")
        rootView = inflater.inflate(R.layout.m001fragment, container, false)
        mBinding = M001fragmentBinding.bind(rootView!!)
        initViews()
        return rootView
    }

    private fun initViews() {
        if (mediaPlayer != null) {
            mediaPlayer?.start()
        }else{
            mediaPlayer = MediaPlayer.create(mContext, R.raw.song_1)
            mediaPlayer?.start()
        }
        mBinding?.tvNext?.setOnClickListener {
            Toast.makeText(mContext, "click", Toast.LENGTH_LONG).show()
            mediaPlayer?.pause()
            val act: MainActivity = (mContext as MainActivity)
            act.showFrg()
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
        mediaPlayer?.stop()
        Log.i(TAG, "onDestroy: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView: ")
    }

    companion object {
        val TAG: String? = M001Fragment.javaClass.name
    }
}