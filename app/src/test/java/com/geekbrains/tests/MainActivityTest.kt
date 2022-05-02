package com.geekbrains.tests

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.view.details.DetailsActivity
import com.geekbrains.tests.view.search.MainActivity
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var context: Context

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun activity_AssertNonNull() {
        scenario.onActivity {
            assertNotNull(it)
        }
    }

    @Test
    fun activity_isResumed() {
        assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    // проверка наличия  и видимости всех View
    @Test
    fun progressBar_AssertNotNull() {
        scenario.onActivity {
            val progressBar = it.findViewById<ProgressBar>(R.id.progressBar)

            assertNotNull(progressBar)
        }
    }

    @Test
    fun progressBar_isVisible() {
        scenario.onActivity {
            val progressBar = it.findViewById<ProgressBar>(R.id.progressBar)

            assertEquals(View.GONE, progressBar.visibility)
        }
    }

    @Test
    fun searchEditText_AssertNotNull() {
        scenario.onActivity {
            val searchEditText = it.findViewById<EditText>(R.id.searchEditText)

            assertNotNull(searchEditText)
        }
    }

    @Test
    fun searchEditText_isVisible() {
        scenario.onActivity {
            val searchEditText = it.findViewById<EditText>(R.id.searchEditText)

            assertEquals(View.VISIBLE, searchEditText.visibility)
        }
    }

    @Test
    fun toDetailsActivityButton_AssertNotNull() {
        scenario.onActivity {
            val toDetailsActivityButton = it.findViewById<Button>(R.id.toDetailsActivityButton)

            assertNotNull(toDetailsActivityButton)
        }
    }

    @Test
    fun toDetailsActivityButton_isVisible() {
        scenario.onActivity {
            val toDetailsActivityButton = it.findViewById<Button>(R.id.toDetailsActivityButton)

            assertEquals(View.VISIBLE, toDetailsActivityButton.visibility)
        }
    }

    @Test
    fun recyclerview_AssertNotNull() {
        scenario.onActivity {
            val recyclerView = it.findViewById<RecyclerView>(R.id.recyclerView)

            assertNotNull(recyclerView)
        }
    }

    @Test
    fun recyclerview_isVisible() {
        scenario.onActivity {
            val recyclerView = it.findViewById<RecyclerView>(R.id.recyclerView)

            assertEquals(View.VISIBLE, recyclerView.visibility)
        }
    }

    // проверка правильности ввода и получения текста в EditText
    @Test
    fun searchEditText_CheckEdit() {
        scenario.onActivity {
            val searchEditText = it.findViewById<EditText>(R.id.searchEditText)
            searchEditText.setText("test", TextView.BufferType.EDITABLE)
            val res = searchEditText.text.toString()

            assertEquals("test", res)
        }
    }

    @After
    fun close() {
        scenario.close()
    }
}