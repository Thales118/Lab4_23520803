package com.example.tudienuit;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db_hoc_tap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // 1. Tạo Database an toàn theo MODE_PRIVATE
            db_hoc_tap = openOrCreateDatabase("TuDienUIT.db", MODE_PRIVATE, null);
            db_hoc_tap.execSQL("CREATE TABLE IF NOT EXISTS tu_dien(tu TEXT, nghia TEXT)");

            // 2. Thêm dữ liệu mẫu (Thêm nhiều từ để bài làm đầy đặn)
            db_hoc_tap.execSQL("INSERT INTO tu_dien VALUES('verisimilitude', 'vẻ ngoài có vẻ đúng hoặc thật')");
            db_hoc_tap.execSQL("INSERT INTO tu_dien VALUES('database', 'cơ sở dữ liệu')");
            db_hoc_tap.execSQL("INSERT INTO tu_dien VALUES('android', 'hệ điều hành mã nguồn mở')");
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi khởi tạo DB", Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.btn_tra_cuu).setOnClickListener(v -> {
            String tu_can_tim = ((EditText)findViewById(R.id.et_nhap_tu)).getText().toString().trim();
            if(tu_can_tim.isEmpty()) return;

            // 3. Sử dụng Cursor để tìm kiếm substring
            Cursor con_tro = db_hoc_tap.rawQuery("SELECT * FROM tu_dien WHERE tu LIKE ?",
                    new String[]{"%" + tu_can_tim + "%"});

            StringBuilder ket_qua = new StringBuilder();
            if (con_tro != null && con_tro.moveToFirst()) {
                do {
                    String tu_goc = con_tro.getString(0);
                    String nghia_goc = con_tro.getString(1);
                    ket_qua.append("🔍 ").append(tu_goc).append("\n- ").append(nghia_goc).append("\n\n");
                } while (con_tro.moveToNext());
                ((TextView)findViewById(R.id.tv_hien_thi)).setText(ket_qua.toString());
            } else {
                ((TextView)findViewById(R.id.tv_hien_thi)).setText("Không tìm thấy kết quả phù hợp.");
            }
            if (con_tro != null) con_tro.close();
        });
    }
}