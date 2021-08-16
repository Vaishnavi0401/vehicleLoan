import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UploadFilesService } from '../upload-files.service';

@Component({
  selector: 'app-admin-dashboard-files',
  templateUrl: './admin-dashboard-files.component.html',
  styleUrls: ['./admin-dashboard-files.component.css']
})
export class AdminDashboardFilesComponent implements OnInit {

  isAdminLoggedIn: string;
  fileInfos: Observable<any>;

  constructor(private uploadService: UploadFilesService) { }

  ngOnInit(): void {
    this.fileInfos = this.uploadService.getFiles();
    this.isAdminLoggedIn = sessionStorage.getItem("isAdminLoggedIn");
  }

}
