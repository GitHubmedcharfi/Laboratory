import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent {
  // Inject MatDialogRef to close the dialog from here
  constructor(public dialogRef: MatDialogRef<ConfirmComponent>) { }
}
