package com.wl.androidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wl.androidlearning.designpattern.adapter.AudioPlayer
import com.wl.androidlearning.designpattern.bridge.GreenCircle
import com.wl.androidlearning.designpattern.bridge.RedCircle
import com.wl.androidlearning.designpattern.builder.MealBuilder
import com.wl.androidlearning.designpattern.composite.Employee
import com.wl.androidlearning.designpattern.decorator.RedShapeDectorator
import com.wl.androidlearning.designpattern.factory.FactoryProducer
import com.wl.androidlearning.designpattern.factory.ShapeFactory
import com.wl.androidlearning.designpattern.prototype.Circle
import com.wl.androidlearning.designpattern.prototype.Rectangle
import com.wl.androidlearning.designpattern.prototype.ShapeCache
import com.wl.androidlearning.designpattern.prototype.Square
import com.wl.androidlearning.designpattern.singleton.SingleObject
import com.wl.androidlearning.designpattern.singleton.Singleton
import com.wl.androidlearning.designpattern.singleton.SingletonEnum
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

                it.data?.forEach {
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


        patternLearning()
    }

    private fun patternLearning() {
        //工厂模式

//        var circle = ShapeFactory.createShape("circle")
//        var rectangle = ShapeFactory.createShape("rectangle")
//        var square = ShapeFactory.createShape("square")
//
//        circle?.draw()
//        rectangle?.draw()
//        square?.draw()

        //抽象工厂模式
        var shapeFactory = FactoryProducer.createFactory("shapeFactory")
        var circle = shapeFactory?.createShape("circle")
        var rectangle = shapeFactory?.createShape("rectangle")
        var square = shapeFactory?.createShape("square")

        circle?.draw()
        rectangle?.draw()
        square?.draw()

        var colorFactory = FactoryProducer.createFactory("colorFactory")
        var red = colorFactory?.createColor("red")
        var green = colorFactory?.createColor("green")
        var blue = colorFactory?.createColor("blue")

        red?.fill()
        green?.fill()
        blue?.fill()


        var singleObject = SingleObject.getInstance()
        singleObject.showMessage()

        var singleton = Singleton.getInstance()
        singleton.showMessage()

        var singletonEnum = SingletonEnum.INSTANCE
        singletonEnum.showMessage()


        Log.d("test","newfdsfasdftest")

        var mealBuilder = MealBuilder()
        var meal = mealBuilder.createNoVegMeal()
        meal.cost
        meal.showItems()

        var mealB =  mealBuilder.createVegMeal()
        mealB.cost
        mealB.showItems()

        //原型模式
        ShapeCache.loadCatch()


        var circleProto =  ShapeCache.getShape("1") as Circle
        var rectangleProto =  ShapeCache.getShape("2") as Rectangle
        var squareProto =  ShapeCache.getShape("3") as Square
        Log.d("proto","circle:${circleProto.type}--rect:${rectangleProto.type}--suqare:${squareProto.type}")


        //适配器模式
        var audioPlayer = AudioPlayer()
        audioPlayer.play("mp3","月亮之上")
        audioPlayer.play("mp4","天下足球")
        audioPlayer.play("vlc","锵锵行天下")
        audioPlayer.play("mkv","我们这一天")

        //桥接模式
        var redCircle = com.wl.androidlearning.designpattern.bridge.Circle(RedCircle(),5,40,40)
        redCircle.draw()

        var greenCircle = com.wl.androidlearning.designpattern.bridge.Circle(GreenCircle(),5,40,40);
        greenCircle.draw()

        //组合模式
        var xuLiang = Employee("徐亮",100000,"总经办")
        var liWei = Employee("李威",10000,"IT部")
        var xiuLiNa = Employee("修丽娜",7000,"人事部")
        var wangLei = Employee("王磊",6000,"IT部")
        var hanHang = Employee("韩航",6000,"IT部")
        var zhangRuiQiang = Employee("张瑞强",5000,"人事部")

        xuLiang.addEmployee(liWei)
        xuLiang.addEmployee(xiuLiNa)
        liWei.addEmployee(wangLei)
        liWei.addEmployee(hanHang)
        xiuLiNa.addEmployee(zhangRuiQiang)

        LogUtils.d("composite","name:${xuLiang}")
        xuLiang.subordinates.forEach {
        LogUtils.d("composite","name:${it}")
            it.subordinates.forEach{
                LogUtils.d("composite","name:${it}")
            }
        }

        //装饰器模式

        var redCircleShapeDectorator = RedShapeDectorator(com.wl.androidlearning.designpattern.decorator.Circle())

        var redRectangleDectorator = RedShapeDectorator(com.wl.androidlearning.designpattern.decorator.Rectangle())

        redCircleShapeDectorator.draw()
        redRectangleDectorator.draw()




    }
}