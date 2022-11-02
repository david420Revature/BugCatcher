package com.revature.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
import java.time.Duration;

public abstract class ManualRunner extends JPanel implements ActionListener {

    private boolean fail = false;
    private boolean state = false;
    private boolean stop = false;
    private JLabel prompt;
    private JButton nextButton;
    private JButton failButton;
    private JButton stopButton;

    protected WebDriver driver;
    protected WebDriverWait wait;
    public boolean getFail() {
        return fail;
    }

    public boolean getStop() {
        return stop;
    }

    public ManualRunner() {
        prompt = new JLabel("replace this text with setText(String text)",JLabel.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        failButton = new JButton("Fail");
        failButton.addActionListener(this);

        stopButton = new JButton("Unimplemented");
        stopButton.addActionListener(this);

        JPanel controls = new JPanel();

        controls.setLayout(new GridLayout(1,3));

        controls.add(nextButton);
        controls.add(failButton);
        controls.add(stopButton);

        setLayout(new GridLayout(2,1));
        add(prompt);
        add(controls);


        setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
    }

    public boolean ready() {
        if (state) {
            state = false;
            return true;
        }
        else return state;
    }

    public void fail() {
        fail = true;
        ready();
    }

    public void stop() {
        stop = true;
        ready();
    }

    public void setText(String text) {
        prompt.setText(text);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(failButton)) {
            fail = true;
        }
        state = true;
    }

}

