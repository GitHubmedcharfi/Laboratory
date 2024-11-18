import { Component, OnInit } from '@angular/core';
import { Member } from '../../models/member';
import { MemberService } from 'src/service/member-service.service';
import { ConfirmComponent } from '../confirm/confirm.component';
import { MatDialog } from '@angular/material/dialog'; 

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {
  
  constructor(
    private MS: MemberService,
    private dialog: MatDialog // Inject MatDialog
  ) {}

  displayedColumns: string[] = ['1', '2', '3', '4', '5', '6', '7'];
  dataSource: Member[] = [];

  ngOnInit(): void {
    // Fetch all members initially
    this.MS.getAllMembers().subscribe((response: Member[]) => {
      this.dataSource = response; // Assign response to dataSource
    });
  }

  // Delete member method
  delete(id: string): void {
    // Open the confirmation dialog
    const dialogRef = this.dialog.open(ConfirmComponent);

    // Wait for the dialog result (response from user)
    dialogRef.afterClosed().subscribe((response: boolean) => { // Explicitly set type as boolean
      if (response) {
        // If confirmed, call the delete method from the service
        this.MS.deleteMember(id).subscribe(() => {
          // After deletion, fetch the updated list of members
          this.MS.getAllMembers().subscribe((response: Member[]) => {
            this.dataSource = response;
          });
        });
      }
    });
  }
}
