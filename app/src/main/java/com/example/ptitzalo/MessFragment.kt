package com.example.ptitzalo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MessFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MessFragment : Fragment(), MessAdapter.CallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mess, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        setAction()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var mutableList: MutableList<MessModel>
    private lateinit var messAdapter: MessAdapter

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.mess_list_recycler_view)
        mutableList = mutableListOf()

        var messModel1 = MessModel("4", "Bố", "Bố ơi", "8 giờ")
        var messModel2 = MessModel("2", "Cô giáo kính yêu", "Chúc cô sức khỏe ạ", "12 giờ")
        var messModel3 = MessModel("3", "Cô giáo kính yêu", "Quý cô quá đi", "14 giờ")
        var messModel4 = MessModel("5", "Mẹ", "Mẹ khỏe không?", "23/04/2021")
        var messModel5 = MessModel("1", "Kim Anh C3", "Ăn ốc ha", "19/04/2021")
        var messModel6 = MessModel("1", "Sơn Khương IT", "Lam bài tập di", "18/04/2021")

        mutableList.add(messModel1)
        mutableList.add(messModel2)
        mutableList.add(messModel3)
        mutableList.add(messModel4)
        mutableList.add(messModel5)
        mutableList.add(messModel6)

        messAdapter = MessAdapter(mutableList, this)
        var staggeredGridLayoutManager: StaggeredGridLayoutManager =
            StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
        recyclerView.adapter = messAdapter
    }

    private fun setAction() {

    }

    companion object {
        fun newInstance() =
            MessFragment().apply {
                arguments = Bundle().apply {
                }
            }

    }

    override fun onClickMess(int: Int, messModel: MessModel) {

    }
}
