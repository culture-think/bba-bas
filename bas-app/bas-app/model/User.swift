//
//  User.swift
//  bas-app
//
//  Created by zhanghf on 2018/7/23.
//  Copyright © 2018 flynet. All rights reserved.
//

import UIKit

class User {
    
    //MARK: Properties
    
    var id: String = ""
    var account: String = ""
    var name: String = ""
    var password: String = ""
    var photo: UIImage?
    
    init?(id: String, account: String, name: String, password: String, photo: UIImage?) {
        if id.isEmpty || account.isEmpty || password.isEmpty {
            return nil
        }
        self.id = id
        self.account = account
        self.name = name
        self.password = password
        self.photo = photo
    }
}
