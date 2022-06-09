import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandevalideeComponent } from './commandevalidee.component';

describe('CommandevalideeComponent', () => {
  let component: CommandevalideeComponent;
  let fixture: ComponentFixture<CommandevalideeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommandevalideeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CommandevalideeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
