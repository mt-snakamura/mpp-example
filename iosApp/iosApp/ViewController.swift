//
//  ViewController.swift
//  iosApp
//
//  Created by So on 2019/04/04.
//  Copyright © 2019 So. All rights reserved.
//

import UIKit
import MTLib

class ViewController: UIViewController {

    private lazy var dataSource: UITableViewDataSource = {
        return EraDataSource(data: EraLoader.Companion().loadEras())
    }()

    private lazy var tableView: UITableView = {
        let tableView = UITableView()
        tableView.dataSource = dataSource
        return tableView
    }()

    override func viewDidLoad() {
        super.viewDidLoad()
        view.addSubview(tableView)
        tableView.reloadData()

        tableView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            tableView.topAnchor.constraint(equalTo: view.topAnchor),
            tableView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            tableView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            tableView.trailingAnchor.constraint(equalTo: view.trailingAnchor)
        ])
    }
}

class EraDataSource: NSObject, UITableViewDataSource {

    private let eras: [Era]

    init(data: [Era]) {
        self.eras = data
        super.init()
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return eras.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell(style: .subtitle, reuseIdentifier: nil)
        cell.textLabel?.text = eras[indexPath.row].name
        cell.detailTextLabel?.text = eras[indexPath.row].nameKanji
        return cell
    }
}
