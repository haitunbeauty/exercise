package com.ultimate.www.component_application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ultimate.www.component_application.ui.me.MeViewModel;
import com.ultimate.www.component_application.utils.ToastUtil;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

/**
 * @author 李宝
 * @date 2019/12/31
 * @Describe 单主页
 * @Describe 如果自定义icon和文字的颜色 参考：https://www.cnblogs.com/Free-Thinker/p/8981930.html
 */
public class MainActivity extends AppCompatActivity {

    private MainViewModule mainViewModel;



    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModule.class);
        initData();
        final BottomNavigationView navView = findViewById(R.id.nav_view);

        int[][] states = new int[][]{
                new int[]{ -android.R.attr.state_checked},
                new int[]{android.R.attr.state_checked}
        };
        int[] colors = new int[]{
                getResources().getColor(R.color.checked_color),
                getResources().getColor(R.color.uncheck_color)
        };
        ColorStateList csl = new ColorStateList(states, colors);
        navView.setItemTextColor(csl);
        navView.setItemIconTintList(csl);


        //获取整个的NavigationView
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navView.getChildAt(0);
        //这里就是获取所添加的每一个Tab(或者叫menu)，
        View tab = menuView.getChildAt(3);
        BottomNavigationItemView itemView = (BottomNavigationItemView) tab;
        //加载我们的角标View，新创建的一个布局
        View badge = LayoutInflater.from(this).inflate(R.layout.menu_badge, menuView, false);
        //添加到Tab上
        itemView.addView(badge);
        TextView count = (TextView) badge.findViewById(R.id.tv_msg_count);

        count.setText(mainViewModel.getMsgCount().getValue()+"");//TODO  这个东西不应该在这个页面设置  感觉不科学
        //如果没有消息，不需要显示的时候那只需要将它隐藏即可
//        count.setVisibility(View.GONE);



//        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.navigation_function:
//                        ToastUtil.show(MainActivity.this,"我是功能菜单");
//                        break;
//                }
//                return false;
//            }
//        });


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_function,R.id.navigation_personcenter)
//                .build();
        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                BottomNavigationView view = navView;
                if (view == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = view.getMenu();
                for (int h = 0, size = menu.size(); h < size; h++) {
                    MenuItem item = menu.getItem(h);
                    if (matchDestination(destination, item.getItemId())) {
                        item.setChecked(true);
                    }
                }
            }
        });

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                NavOptions.Builder builder = new NavOptions.Builder()
                        .setLaunchSingleTop(true)
                        .setEnterAnim(R.anim.nav_default_enter_anim)
                        .setExitAnim(R.anim.nav_default_exit_anim)
                        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                        .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
                if ((item.getOrder() & Menu.CATEGORY_SECONDARY) == 0) {//Todo  这个条件是判断是否是第一个fragment（HomeFragment 相当于主页）
                    builder.setPopUpTo(findStartDestination(navController.getGraph()).getId(), false);
                }
                NavOptions options = builder.build();
                try {
                    //TODO provide proper API instead of using Exceptions as Control-Flow.
                    navController.navigate(item.getItemId(), null, options);
                    return true;
                } catch (IllegalArgumentException e) {
                    return false;
                }
            }
        });








    }

    static boolean matchDestination(@NonNull NavDestination destination,
                                    @IdRes int destId) {
        NavDestination currentDestination = destination;
        while (currentDestination.getId() != destId && currentDestination.getParent() != null) {
            currentDestination = currentDestination.getParent();
        }
        return currentDestination.getId() == destId;
    }

    static NavDestination findStartDestination(@NonNull NavGraph graph) {
        NavDestination startDestination = graph;
        while (startDestination instanceof NavGraph) {
            NavGraph parent = (NavGraph) startDestination;
            startDestination = parent.findNode(parent.getStartDestination());
        }
        return startDestination;
    }


    private void initData() {
    }

}
