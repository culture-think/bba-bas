//
//  bas_appTests.swift
//  bas-appTests
//
//  Created by zhanghf on 2018/7/9.
//  Copyright © 2018 flynet. All rights reserved.
//

import XCTest
@testable import bas_app

class bas_appTests: XCTestCase {
    
    override func setUp() {
        super.setUp()
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }
    
    func testExample() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
    }
    
    func testPerformanceExample() {
        // This is an example of a performance test case.
        self.measure {
            // Put the code you want to measure the time of here.
        }
    }
    
    func testUserInitializationSucceeds(){
        let user = User.init(id: "123", account: "123@flynet.com", name: "Basil Chuang", password: "123456", photo: nil)
        XCTAssertNotNil(user)
    }
    
}
