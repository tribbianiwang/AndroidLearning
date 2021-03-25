package com.wl.androidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.hiltsample.retrofit.RetrofitService
import com.google.gson.Gson
import com.wl.androidlearning.designpattern.factory.ShapeFactory
import com.wl.androidlearning.fragment.HomeFragment
import com.wl.androidlearning.hilt.HiltSample
import com.wl.androidlearning.hilt.Truck
import com.wl.androidlearning.utils.LogUtils
import com.wl.androidlearning.viewmodel.FoodTasteViewModel
import com.wl.androidlearning.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var hiltSample:HiltSample
    @Inject
    lateinit var truck: Truck

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var retrofit: Retrofit

    private val viewModel: MyViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }

    private val foodTasteViewModel:FoodTasteViewModel by lazy { ViewModelProvider(this).get(FoodTasteViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        truck.deliver()

        LogUtils.d("okhttpclient",okHttpClient.toString())
        LogUtils.d("retrofit",retrofit.toString())
        //工厂模式

        var circle = ShapeFactory.createShape("circle")
        var rectangle = ShapeFactory.createShape("rectangle")
        var square = ShapeFactory.createShape("square")

        circle?.draw()
        rectangle?.draw()
        square?.draw()


        hiltSample.doSomeThing()

        bt_get_province.setOnClickListener {

//            val apiService = retrofit.create(RetrofitService::class.java)
//            lifecycleScope.launch(Dispatchers.IO) {
//                val foodTasteBeanItems = apiService.getFoodTaste()
//                LogUtils.d("mair","onclick-2-${Gson().toJson(foodTasteBeanItems)}")
//            }

            foodTasteViewModel.getFoodTaste()


        }


        foodTasteViewModel.apply {
            foodTastesLiveData.observe(this@MainActivity, Observer {
                it.forEach {
                    LogUtils.d("testlviewmodel","taste:${it.name}")
                }
            })

            queryStatusLiveData.observe(this@MainActivity, Observer {
                LogUtils.d("testlviewmodel","status:${it}")
            })

            errorMsgLiveData.observe(this@MainActivity, Observer {
                LogUtils.e("testlviewmodel","error:${it}")
            })

        }



        bt_do_work.setOnClickListener {
            viewModel.doWork()
        }

        supportFragmentManager.beginTransaction().replace(R.id.cons_root,HomeFragment::class.java,null).commit()
    }
}