//
//  ViewController.swift
//  bas-app
//
//  Created by zhanghf on 2018/7/9.
//  Copyright © 2018 flynet. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {
    @IBOutlet weak var accountTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func loginButtonPressed(_ sender: UIButton) {
        if(accountTextField.text == "admin" && passwordTextField.text == "123") {
            NSLog("Login successfully...")
            return
        }
        NSLog("Login Failed...")
    }
    
}

