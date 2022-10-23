package com.example.projectexam.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectexam.R
import com.example.projectexam.ui.adapter.AppliAdapter
import com.example.projectexam.databinding.FragmentAppliBinding
import com.example.projectexam.ui.model.AppliModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AppliFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AppliFragment : Fragment() {

    private lateinit var binding: FragmentAppliBinding
    private lateinit var adapter: AppliAdapter
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
        binding = FragmentAppliBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvAppli.layoutManager = LinearLayoutManager(requireActivity())

        val appliList = ArrayList<AppliModel>()
        appliList.add(AppliModel("Back-End Developer", "Tokopedia", R.drawable.jobs2))
        appliList.add(AppliModel("FrontEnd Developer", "Shopee", R.drawable.jobs3))
        appliList.add(AppliModel("IT Support", "Bukalapak", R.drawable.jobs4))
        appliList.add(AppliModel("Back-End Developer", "Tokopedia", R.drawable.jobs2))
        appliList.add(AppliModel("FrontEnd Developer", "Shopee", R.drawable.jobs3))
        appliList.add(AppliModel("IT Support", "Bukalapak", R.drawable.jobs4))
        appliList.add(AppliModel("Back-End Developer", "Tokopedia", R.drawable.jobs2))
        appliList.add(AppliModel("FrontEnd Developer", "Shopee", R.drawable.jobs3))
        appliList.add(AppliModel("IT Support", "Bukalapak", R.drawable.jobs4))
        appliList.add(AppliModel("Back-End Developer", "Tokopedia", R.drawable.jobs2))
        appliList.add(AppliModel("FrontEnd Developer", "Shopee", R.drawable.jobs3))
        appliList.add(AppliModel("IT Support", "Bukalapak", R.drawable.jobs4))


        adapter = AppliAdapter(appliList)

        binding.rvAppli.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AppliFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AppliFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}