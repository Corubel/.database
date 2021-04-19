package com.example.petagramm3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.petagramm3.Adaptador.MascotaAdaptador;
import com.example.petagramm3.Adaptador.PageAdapter;
import com.example.petagramm3.Fragment.PerfilFragment;
import com.example.petagramm3.Fragment.RecyclerViewFragment;
import com.example.petagramm3.JavaMail.Formulario;
import com.example.petagramm3.Pogo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private androidx.appcompat.widget.Toolbar myActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();



        if (myActionBar != null){
            setSupportActionBar(myActionBar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(false);
                actionBar.setDisplayUseLogoEnabled(false);
            }
        }



    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_dogs);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_hotdog);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_Favs:

                Intent intent = new Intent(this, Favoritos.class);
                startActivity(intent);

                return true;
            case R.id.mContacto:
                Toast.makeText(this, "Contacto", Toast.LENGTH_SHORT).show();
                Intent f = new Intent(this, Formulario.class);
                startActivity(f);
                return true;
            case R.id.mAcercaDe:
                Toast.makeText(this, "Acerca de", Toast.LENGTH_SHORT).show();
                Intent b = new Intent(this, BioDesarrollador.class);
                startActivity(b);
                return true;
            case  R.id.mConfigurarCuenta:
                Toast.makeText(this, "Configurar Cuenta", Toast.LENGTH_SHORT).show();
                Intent c = new Intent(this, ConfigurarCuenta.class);
                startActivity(c);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}