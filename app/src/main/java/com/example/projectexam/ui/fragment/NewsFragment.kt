package com.example.projectexam.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectexam.R
import com.example.projectexam.databinding.FragmentNewsBinding
import com.example.projectexam.ui.activity.DetailNewsActivity
import com.example.projectexam.ui.adapter.AppliAdapter
import com.example.projectexam.ui.adapter.NewsAdapter
import com.example.projectexam.ui.model.AppliModel
import com.example.projectexam.ui.model.news.Article
import com.example.projectexam.ui.viewmodel.RandomNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.M)
/// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class NewsFragment : Fragment(), NewsAdapter.NewsSelected {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: NewsAdapter
    private val viewModel: RandomNewsViewModel by viewModels()
    private var list = ArrayList<Article>()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNews.layoutManager = LinearLayoutManager(context)
        viewModel.verifyApi("ab8c596e4a384db09a0602ca9396af83")
        setObserver()
    }

    private fun setObserver() {
        viewModel.getVerifyApiResponseLiveData().observe(viewLifecycleOwner, Observer {
//            adapter = NewsAdapter(it)
            binding.rvNews.adapter = adapter

        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onNewsSelected(article: Article) {
    }
}