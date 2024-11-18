import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MemberService } from 'src/service/member-service.service';
import { Member } from 'src/models/member';

@Component({
  selector: 'app-member-form',
  templateUrl: './member-form.component.html',
  styleUrls: ['./member-form.component.css']
})
export class MemberFormComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  idcourant: string | null = null; // To store the current member ID

  constructor(
    private MS: MemberService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // Get the member ID from the route parameters (for editing)
    this.idcourant = this.activatedRoute.snapshot.params['id'];

    // Initialize form first
    this.initCreateForm();

    // Determine whether we're creating or updating
    if (this.idcourant) {
      // Fetch member data for edit mode
      this.MS.getMemberById(this.idcourant).subscribe((data: Member) => {
        this.initUpdateForm(data);
      });
    }
  }

  // Initialize form for creating a new member
  initCreateForm(): void {
    this.form = new FormGroup({
      cin: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      cv: new FormControl('', [Validators.required]),
      type: new FormControl('', [Validators.required]),
      createDate: new FormControl('', [Validators.required])
    });
  }

  // Initialize form with data for updating an existing member
  initUpdateForm(member: Member): void {
    this.form.patchValue({
      cin: member.cin,
      name: member.name,
      cv: member.cv,
      type: member.type,
      createDate: member.createDate
    });
  }

  // Handle form submission
  sub(): void {
    console.log('Form Submitted:', this.form.value);

    // Check if we are in edit mode or create mode
    if (this.idcourant) {
      // Update existing member
      this.MS.updateMember(this.idcourant, this.form.value).subscribe(() => {
        this.router.navigate(['/member']);
      });
    } else {
      // Create new member
      this.MS.save(this.form.value).subscribe(() => {
        this.router.navigate(['/member']);
      });
    }
  }
}
