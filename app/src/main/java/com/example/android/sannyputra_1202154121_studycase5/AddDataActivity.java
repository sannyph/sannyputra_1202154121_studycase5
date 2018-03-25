package com.example.android.sannyputra_1202154121_studycase5;

public class AddDataActivity {
    //deklarasi variable
    String todo, descript, priority;

    //konstruktor
    public AddDataActivity(String todo, String desc, String prior){
        this.todo=todo;
        this.descript=desc;
        this.priority=prior;
    }

    //method setter dan getter untuk to do , description dan priority
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDesc() {
        return descript;
    }

    public void setDesc(String desc) {
        this.descript = desc;
    }

    public String getPrior() {
        return priority;
    }

    public void setPrior(String prior) {
        this.priority = prior;
    }
}
